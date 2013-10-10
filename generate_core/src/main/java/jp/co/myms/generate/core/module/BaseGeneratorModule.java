package jp.co.myms.generate.core.module;

import jp.co.myms.generate.core.name.NameComputer;
import jp.co.myms.generate.core.name.SimpleNameComputer;
import jp.co.myms.generate.core.task.GeneratorTaskMonitor;
import jp.co.myms.generate.core.task.LogTaskMonitor;
import jp.co.myms.generate.core.template.TemplateInfoCreater;
import jp.co.myms.generate.core.validate.BaseGeneratorValidator;
import jp.co.myms.generate.core.validate.GeneratorParameterValidator;

/**
 * ジェネレータ実行モジュール.インスタンスの生成は{@link BaseGeneratorModuleBuilder}を利用する.<br>
 * 
 * @param <T> テンプレートパラメータの型
 * @author myms
 */
public class BaseGeneratorModule<T> implements GeneratorModule<T> {

	/** 名前計算クラス. */
	private NameComputer<T> nameComputer = new SimpleNameComputer<>();
	/** テンプレートバインド情報 生成クラス. */
	private final TemplateInfoCreater<T> templateInfoCreater;
	/** パラメータバリデータ. */
	private GeneratorParameterValidator<T> generatorParameterValidator = new BaseGeneratorValidator<>();
	/** ジェネレータタスクモニター. */
	private GeneratorTaskMonitor generatorTaskMonitor = new LogTaskMonitor();

	/**
	 * コンストラクタ.
	 * 
	 * @param templateInfoCreater テンプレート変数生成クラス
	 */
	public BaseGeneratorModule(TemplateInfoCreater<T> templateInfoCreater) {
		this.templateInfoCreater = templateInfoCreater;
	}

	/**
	 * 名前計算クラスを取得する.
	 * 
	 * @return 名前計算クラス
	 */
	@Override
	public NameComputer<T> getNameComputer() {
		return nameComputer;
	}

	/**
	 * 名前計算クラスを設定する.
	 * 
	 * @param nameComputer 名前計算クラス
	 */
	public void setNameComputer(NameComputer<T> nameComputer) {
		this.nameComputer = nameComputer;
	}

	/**
	 * テンプレートバインド情報 生成クラスを取得する.
	 * 
	 * @return テンプレートバインド情報 生成クラス
	 */
	@Override
	public TemplateInfoCreater<T> getTemplateInfoCreater() {
		return templateInfoCreater;
	}

	/**
	 * パラメータバリデータを取得する.
	 * 
	 * @return パラメータバリデータ
	 */
	@Override
	public GeneratorParameterValidator<T> getGeneratorParameterValidator() {
		return generatorParameterValidator;
	}

	/**
	 * パラメータバリデータを設定する.
	 * 
	 * @param generatorParameterValidator パラメータバリデータ
	 */
	public void setGeneratorParameterValidator(GeneratorParameterValidator<T> generatorParameterValidator) {
		this.generatorParameterValidator = generatorParameterValidator;
	}

	/**
	 * ジェネレータタスクモニターを取得する.
	 * 
	 * @return ジェネレータタスクモニター
	 */
	@Override
	public GeneratorTaskMonitor getGeneratorTaskMonitor() {
		return generatorTaskMonitor;
	}

	/**
	 * ジェネレータタスクモニターを設定する.
	 * 
	 * @param generatorTaskMonitor ジェネレータタスクモニター.
	 */
	public void setGeneratorTaskMonitor(GeneratorTaskMonitor generatorTaskMonitor) {
		this.generatorTaskMonitor = generatorTaskMonitor;
	}
}
