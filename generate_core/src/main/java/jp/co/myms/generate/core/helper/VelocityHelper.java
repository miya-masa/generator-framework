package jp.co.myms.generate.core.helper;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

import jp.co.myms.generate.core.exception.VelocityRuntimeException;

import org.apache.commons.io.IOUtils;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;

/**
 * Velocityを利用するためのヘルパークラス.
 * 
 * @author myms
 *
 */
public class VelocityHelper {

	/** 上書き用設定ファイル. */
	private static final String PRIMARY_VELOCITY_PROPS = "velocity.properties";

	/** デフォルトで使用されるVelocity設定ファイル.*/
	private static final String DEFAULT_VELOCITY_PROPS = "jp/co/myms/generate/core/velocity.properties";

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
	 * @param outputPath 出力先ファイルパス
	 */
	public void merge(String templatePath, String outputPath) {
		try (Writer writer = new BufferedWriter(new FileWriter(new File(outputPath)))) {
			merge(templatePath, writer);
		} catch (IOException e) {
			throw new VelocityRuntimeException("Velocityのマージ中に例外が発生しました。", e);
		}
	}

	/**
	 * マージする.
	 * 
	 * @param templatePath テンプレートファイル名
	 * @param outputFile 出力先ファイル
	 */
	public void merge(String templatePath, File outputFile) {

		try (Writer writer = new BufferedWriter(new FileWriter(outputFile))) {
			merge(templatePath, writer);
		} catch (IOException e) {
			throw new VelocityRuntimeException("Velocityのマージ中に例外が発生しました。", e);
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
			throw new VelocityRuntimeException("Velocityのマージ中に例外が発生しました。", e);
		}
	}

	/**
	 * 全て属性を追加する.
	 * 
	 * @param keyValueMap キーバリューMap
	 */
	public void putAll(Map<String, Object> keyValueMap) {
		for (Entry<String, Object> entry : keyValueMap.entrySet()) {
			put(entry.getKey(), entry.getValue());
		}
	}

}
