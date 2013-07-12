package jp.co.myms.generate.core.module;

import jp.co.myms.generate.core.name.NameComputer;
import jp.co.myms.generate.core.name.SimpleNameComputer;
import jp.co.myms.generate.core.task.GeneratorTaskMonitor;
import jp.co.myms.generate.core.task.LogTaskMonitor;
import jp.co.myms.generate.core.template.TemplateInfoCreater;
import jp.co.myms.generate.core.validate.BaseGeneratorValidator;
import jp.co.myms.generate.core.validate.GeneratorParameterValidator;

/**
 * ジェネレータモジュールを生成する.<br>
 * <code> 
 * GeneratorModule&lt;String&gt; module = new GeneratorModuleBuilder&lt;&gt;(templateInfoCreater).build();
 * </code>
 * 
 * @author myms
 * @param <T>
 */
public class GeneratorModuleBuilder<T> {

	/** 名前計算クラス. */
	private NameComputer<T> nameComputer = new SimpleNameComputer<T>();
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
	public GeneratorModuleBuilder(TemplateInfoCreater<T> templateInfoCreater) {
		this.templateInfoCreater = templateInfoCreater;
	}

	/**
	 * 名前計算クラスを設定する.
	 * 
	 * @param nameComputer 名前計算クラス
	 * @return 自インスタンス
	 */
	public GeneratorModuleBuilder<T> setNameComputer(NameComputer<T> nameComputer) {
		this.nameComputer = nameComputer;
		return this;
	}

	/**
	 * パラメータバリデータを設定する.
	 * 
	 * @param generatorParameterValidator パラメータバリデータ
	 * @return 自インスタンス
	 */
	public GeneratorModuleBuilder<T> setGeneratorParameterValidator(GeneratorParameterValidator<T> generatorParameterValidator) {
		this.generatorParameterValidator = generatorParameterValidator;
		return this;
	}

	/**
	 * ジェネレータタスクモニターを設定する.
	 * 
	 * @param generatorTaskMonitor ジェネレータタスクモニター.
	 * @return 自インスタンス
	 */
	public GeneratorModuleBuilder<T> setGeneratorTaskMonitor(GeneratorTaskMonitor generatorTaskMonitor) {
		this.generatorTaskMonitor = generatorTaskMonitor;
		return this;
	}

	/**
	 * ジェネレータモジュールをビルドする.
	 * 
	 * @return ジェネレータモジュール.
	 */
	public GeneratorModule<T> build() {
		GeneratorModule<T> generatorModule = new GeneratorModule<>(templateInfoCreater);
		generatorModule.setGeneratorParameterValidator(generatorParameterValidator);
		generatorModule.setGeneratorTaskMonitor(generatorTaskMonitor);
		generatorModule.setNameComputer(nameComputer);
		return generatorModule;
	}
}
