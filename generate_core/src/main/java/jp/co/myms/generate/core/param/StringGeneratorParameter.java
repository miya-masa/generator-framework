package jp.co.myms.generate.core.param;


/**
 * template生成に必要なパラメータがString型の生成パラメータ.
 * 
 * @author myms
 *
 */
public class StringGeneratorParameter implements GeneratorParameter<String> {

	/** 出力先. */
	private String outputDirectory;
	/** テンプレートディレクトリ. */
	private String templateDirectory;
	/** テンプレートパラメータ. */
	private String templateParameter;

	/**
	 * 出力先を取得する.
	 * @return 出力先
	 */
	@Override
	public String getOutputDirectory() {
		return this.outputDirectory;
	}

	/**
	 * 出力先を設定する.
	 * @param outputDirectory 出力先
	 */
	public void setOutputDirectory(String outputDirectory) {
		this.outputDirectory = outputDirectory;
	}

	/**
	 * テンプレートディレクトリを取得する.
	 * @return テンプレートディレクトリ
	 */
	@Override
	public String getTemplateDirectory() {
		return this.templateDirectory;
	}

	/**
	 * テンプレートディレクトリを設定する.
	 * @param templateDirectory テンプレートディレクトリ
	 */
	public void setTemplateDirectory(String templateDirectory) {
		this.templateDirectory = templateDirectory;
	}

	/**
	 * テンプレートパラメータを取得する.
	 * @return テンプレートパラメータ
	 */
	@Override
	public String getTemplateParameter() {
		return this.templateParameter;
	}

	/**
	 * テンプレートパラメータを設定する.
	 * @param templateParameter テンプレートパラメータ
	 */
	public void setTemplateParameter(String templateParameter) {
		this.templateParameter = templateParameter;
	}

}
