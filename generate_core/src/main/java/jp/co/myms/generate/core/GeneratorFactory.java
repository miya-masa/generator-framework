package jp.co.myms.generate.core;

/**
 * ジェネレータのファクトリ.
 * 
 * 
 * @author myms
 */
public final class GeneratorFactory {

	/**
	 * 
	 * ジェネレータを生成する.
	 * 
	 * @param <T> テンプレート情報生成パラメータの型
	 * @param module モジュール
	 * @return ジェネレータ
	 */
	public static <T> Generator<T> createGenerator(AbstractGeneratorModule<T> module) {
		Generator<T> generator = new GeneratorImpl<T>(module);
		return generator;
	}

	/**
	 * コンストラクタ.
	 */
	private GeneratorFactory() {

	}
}
