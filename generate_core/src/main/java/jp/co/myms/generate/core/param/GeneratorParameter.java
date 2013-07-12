package jp.co.myms.generate.core.param;

/**
 * 
 * ジェネレータパラメータ.
 * 
 * @param <T> テンプレート変数生成パラメータ
 * @author myms
 */
public interface GeneratorParameter<T> {

	/**
	 * 出力先ディレクトリを取得する.
	 * 
	 * @return 出力先ディレクトリパス
	 */
	String getOutputDirectory();

	/**
	 * テンプレートディレクトリを取得する.
	 * 
	 * @return テンプレートディレクトリパスを取得する.
	 */
	String getTemplateDirectory();

	/**
	 * テンプレートにマージするために必要な情報.
	 * 
	 * @return テンプレートにマージするために必要な情報
	 */
	T getTemplateParameter();

}
