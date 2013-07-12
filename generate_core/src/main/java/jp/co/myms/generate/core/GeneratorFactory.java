package jp.co.myms.generate.core;

import jp.co.myms.generate.core.module.GeneratorModule;

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
	public static <T> Generator<T> createGenerator(GeneratorModule<T> module) {
		Generator<T> generator = new GeneratorImpl<T>(module);
		return generator;
	}

	/**
	 * コンストラクタ.
	 */
	private GeneratorFactory() {
	}
}
