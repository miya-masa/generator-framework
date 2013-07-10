package jp.co.myms.generate.core;

import jp.co.myms.generate.core.param.GeneratorParameter;

/**
 * ジェネレータI/F.
 * 
 * @param <T> テンプレートパラメータの型
 * @author myms
 *
 */
public interface Generator<T> {

	/**
	 * パラメータからファイルを生成する.
	 * 
	 * @param parameter ジェネレータパラメータ
	 */
	GeneratorStatus generate(GeneratorParameter<T> parameter);
}
