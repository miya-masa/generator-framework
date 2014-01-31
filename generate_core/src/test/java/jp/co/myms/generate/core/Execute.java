package jp.co.myms.generate.core;

import java.io.File;

import jp.co.myms.generate.core.mock.MockTemplateInfoCreater;
import jp.co.myms.generate.core.module.StringGeneratorModule;
import jp.co.myms.generate.core.param.StringGeneratorParameter;

import org.apache.commons.lang.StringUtils;

public class Execute {

	public static void main(String[] args) {
		StringGeneratorModule module = new StringGeneratorModule(new MockTemplateInfoCreater());
		StringGenerator generator = GeneratorFactory.createGenerator(StringGenerator.class, module);
		StringGeneratorParameter parameter = new StringGeneratorParameter();
		parameter.setTemplateParameter("テストテストテスト");
		File outputdir = new File("output");
		outputdir.mkdir();
		parameter.setOutputDirectory("output");
		parameter.setTemplateDirectory("template");
		GeneratorStatus status = generator.generate(parameter);
		System.out.println(StringUtils.join(status.getInfoMessages(), "\r\n"));
	}
}
