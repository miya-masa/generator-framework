package jp.co.myms.generate.core;

import java.util.Objects;

import jp.co.myms.generate.core.name.NameComputer;
import jp.co.myms.generate.core.name.SimpleNameComputer;
import jp.co.myms.generate.core.task.GeneratorTaskMonitor;
import jp.co.myms.generate.core.task.LogTaskMonitor;
import jp.co.myms.generate.core.template.TemplateInfoCreater;
import jp.co.myms.generate.core.validate.GeneratorParameterValidator;
import jp.co.myms.generate.core.validate.OKValidator;

/**
 * ジェネレータ実行モジュール.
 * 
 * @param <T> テンプレートパラメータの型
 * @author myms
 */
public abstract class AbstractGeneratorModule<T> {

	/** 名前計算クラス. */
	private NameComputer<T> nameComputer = new SimpleNameComputer<T>();
	/** テンプレートバインド情報 生成クラス. */
	private TemplateInfoCreater<T> templateInfoCreater;
	/** パラメータバリデータ. */
	private GeneratorParameterValidator<T> generatorParameterValidator = new OKValidator<>();

	/** ジェネレータタスクモニター. */
	private GeneratorTaskMonitor generatorTaskMonitor = new LogTaskMonitor();

	/**
	 * コンストラクタ.
	 */
	public AbstractGeneratorModule() {
		configure();
		Objects.requireNonNull(templateInfoCreater, "templateInfoCreaterはNullにはできません.");
	}

	/**
	 * 各モジュールを設定する.
	 * 
	 */
	protected abstract void configure();

	/**
	 * 名前計算クラスを取得する.
	 * 
	 * @return 名前計算クラス
	 */
	public NameComputer<T> getNameComputer() {
		return nameComputer;
	}

	/**
	 * 名前計算クラスを設定する.
	 * 
	 * @param nameComputer 名前計算クラス
	 */
	protected void setNameComputer(NameComputer<T> nameComputer) {
		this.nameComputer = nameComputer;
	}

	/**
	 * テンプレートバインド情報 生成クラスを取得する.
	 * 
	 * @return テンプレートバインド情報 生成クラス
	 */
	public TemplateInfoCreater<T> getTemplateInfoCreater() {
		return templateInfoCreater;
	}

	/**
	 * テンプレートバインド情報 生成クラスを設定する.
	 * 
	 * @param templateInfoCreater テンプレートバインド情報 生成クラス
	 */
	protected void setTemplateInfoCreater(TemplateInfoCreater<T> templateInfoCreater) {
		this.templateInfoCreater = templateInfoCreater;
	}

	/**
	 * パラメータバリデータを取得する.
	 * 
	 * @return パラメータバリデータ
	 */
	public GeneratorParameterValidator<T> getGeneratorParameterValidator() {
		return generatorParameterValidator;
	}

	/**
	 * パラメータバリデータを設定する.
	 * 
	 * @param generatorParameterValidator パラメータバリデータ
	 */
	protected void setGeneratorParameterValidator(GeneratorParameterValidator<T> generatorParameterValidator) {
		this.generatorParameterValidator = generatorParameterValidator;
	}

	/**
	 * ジェネレータタスクモニターを取得する.
	 * 
	 * @return ジェネレータタスクモニター
	 */
	public GeneratorTaskMonitor getGeneratorTaskMonitor() {
		return generatorTaskMonitor;
	}
}
