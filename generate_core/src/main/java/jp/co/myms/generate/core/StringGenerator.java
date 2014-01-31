package jp.co.myms.generate.core;

import jp.co.myms.generate.core.module.GeneratorModule;
import jp.co.myms.generate.core.module.StringGeneratorModule;
import jp.co.myms.generate.core.param.StringGeneratorParameter;

public class StringGenerator extends AbstractGenerator<StringGeneratorParameter, String> {

	public StringGenerator(StringGeneratorModule module) {
		super(module);
	}

}
