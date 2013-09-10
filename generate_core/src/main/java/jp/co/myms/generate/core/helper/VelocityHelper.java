package jp.co.myms.generate.core.helper;

import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.nio.charset.Charset;
import java.util.Map.Entry;
import java.util.Properties;

import jp.co.myms.generate.core.exception.VelocityRuntimeException;
import jp.co.myms.generate.core.resource.ResourceWrapper;
import jp.co.myms.generate.core.resource.ResourceFactory;
import jp.co.myms.generate.core.resource.ResourcesUtils;
import jp.co.myms.generate.core.template.VariableMap;

import org.apache.commons.io.IOUtils;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.runtime.RuntimeConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Velocityを利用するためのヘルパークラス.
 * 
 * @author myms
 * 
 */
public class VelocityHelper {

	/** ロガー. */
	private static final Logger LOGGER = LoggerFactory.getLogger(VelocityHelper.class);

	/** 上書き用設定ファイル. */
	private static final String PRIMARY_VELOCITY_PROPS = "velocity.properties";

	/** デフォルトで使用されるVelocity設定ファイル. */
	private static final String DEFAULT_VELOCITY_PROPS = "jp/co/myms/generate/core/velocity.properties";

	/** 出力エンコーディング. */
	private static final Charset OUTPUT_ENCODING;

	/** Velocityコンテキスト. */
	private final VelocityContext velocityContext;

	static {
		Properties targetProps = null;
		Properties defaultProps = new Properties();

		//デフォルトプロパティをロードする.
		try (InputStream is = VelocityHelper.class.getClassLoader().getResourceAsStream(DEFAULT_VELOCITY_PROPS);) {
			defaultProps.load(is);
		} catch (IOException e1) {
			throw new AssertionError();
		}

		//上書き用プロパティファイルをロードする.
		InputStream is = VelocityHelper.class.getClassLoader().getResourceAsStream(PRIMARY_VELOCITY_PROPS);
		if (is != null) {
			try {
				targetProps = new Properties(defaultProps);
				targetProps.load(is);
			} catch (IOException e) {
				throw new AssertionError();
			} finally {
				IOUtils.closeQuietly(is);
			}
		} else {
			targetProps = defaultProps;
		}
		Velocity.init(targetProps);
		LOGGER.debug(targetProps.toString());
		OUTPUT_ENCODING = Charset.forName((String) Velocity.getProperty(RuntimeConstants.OUTPUT_ENCODING));
	}

	/**
	 * コンストラクタ.
	 */
	public VelocityHelper() {
		this.velocityContext = new VelocityContext();
	}

	/**
	 * コンストラクタ.
	 * 
	 * @param velocityContext Velocityコンテキスト.
	 */
	public VelocityHelper(VelocityContext velocityContext) {
		this.velocityContext = velocityContext;
	}

	/**
	 * Velocityコンテキストに属性をputする.
	 * 
	 * @param key キー
	 * @param value 値
	 */
	public void put(String key, Object value) {
		velocityContext.put(key, value);
	}

	/**
	 * マージする.
	 * 
	 * @param templatePath テンプレートファイルパス
	 * @param outputFile 出力先ファイルパス
	 */
	public void merge(String templatePath, ResourceWrapper outputFile) {
		try (Writer writer = outputFile.getWriter(OUTPUT_ENCODING)) {
			merge(templatePath, writer);
		} catch (IOException e) {
			throw new VelocityRuntimeException("Velocityのマージ中に例外が発生しました.", e);
		}
	}

	/**
	 * マージする.
	 * 
	 * @param templatePath テンプレートファイル名
	 * @param outputFile 出力先ファイル
	 */
	public void merge(String templatePath, String outputFile) {
		ResourceFactory resourceFactory = ResourcesUtils.createFactory();
		try (Writer writer = resourceFactory.createResource(outputFile).getWriter(OUTPUT_ENCODING)) {
			merge(templatePath, writer);
		} catch (IOException e) {
			throw new VelocityRuntimeException("Velocityのマージ中に例外が発生しました.", e);
		}

	}

	/**
	 * マージする.
	 * 
	 * @param templatePath テンプレートファイル名
	 * @param writer 出力ライター
	 */
	public void merge(String templatePath, Writer writer) {
		try {
			Template template = Velocity.getTemplate(templatePath);
			template.merge(velocityContext, writer);
		} catch (Exception e) {
			throw new VelocityRuntimeException("Velocityのマージ中に例外が発生しました.", e);
		}
	}

	/**
	 * 全て属性を追加する.
	 * 
	 * @param variableMap 変数マップ
	 */
	public void putAll(VariableMap variableMap) {
		for (Entry<String, Object> entry : variableMap.entrySet()) {
			put(entry.getKey(), entry.getValue());
		}
	}

}
