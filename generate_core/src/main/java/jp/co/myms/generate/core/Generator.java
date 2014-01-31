package jp.co.myms.generate.core;

import jp.co.myms.generate.core.param.GeneratorParameter;

/**
 * ジェネレータI/F.
 * 
 * @param <T> テンプレートパラメータの型
 * @author myms
 * @param <I>
 * 
 */
public interface Generator<T extends GeneratorParameter<I>, I> {

	/**
	 * パラメータからファイルを生成する.
	 * 
	 * @param parameter ジェネレータパラメータ
	 * @return ジェネレータステータス
	 */
	GeneratorStatus generate(T parameter);
}
