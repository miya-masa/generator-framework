package jp.co.myms.generate.core.mock;

import jp.co.myms.generate.core.param.GeneratorParameter;
import jp.co.myms.generate.core.template.TemplateInfoCreater;
import jp.co.myms.generate.core.template.VariableMap;

public class MockTemplateInfoCreater implements TemplateInfoCreater<String> {

	@Override
	public void setUpVariableMap(VariableMap map, GeneratorParameter<String> parameter) {
		map.put("key0", parameter.getTemplateParameter());
		map.put("key1", parameter.getTemplateParameter());
		map.put("key2", parameter.getTemplateParameter());
	}

}
