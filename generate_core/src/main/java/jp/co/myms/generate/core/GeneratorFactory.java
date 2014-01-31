package jp.co.myms.generate.core;

import java.lang.reflect.InvocationTargetException;

import jp.co.myms.generate.core.module.BaseGeneratorModule;
import jp.co.myms.generate.core.param.GeneratorParameter;

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
	 * @param <G> テンプレート情報生成パラメータの型
	 * @param <I>
	 * @param <T>
	 * @param module モジュール
	 * @return ジェネレータ
	 */
	public static <G extends Generator<T, I>, T extends GeneratorParameter<I>, I> G createGenerator(
			Class<G> generatorImplClass,
			Object... args) {
		G generator = null;
		try {
			Class<?>[] classes = new Class[args.length];

			for (int i = 0; i < args.length; i++) {
				classes[i] = args[i].getClass();
			}
			generator = generatorImplClass.getConstructor(classes).newInstance(args);
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		return generator;
	}

	/**
	 * コンストラクタ.
	 */
	private GeneratorFactory() {
	}
}
