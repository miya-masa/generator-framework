package jp.co.myms.generate.core.mock;

import java.util.HashMap;
import java.util.Map;

import jp.co.myms.generate.core.param.GeneratorParameter;
import jp.co.myms.generate.core.template.TemplateInfoCreater;

public class MockTemplateInfoCreater implements TemplateInfoCreater<String> {

	@Override
	public Map<String, Object> create(GeneratorParameter<String> parameter) {
		Map<String, Object> map = new HashMap<>();
		map.put("key0", parameter.getTemplateParameter());
		map.put("key1", parameter.getTemplateParameter());
		map.put("key2", parameter.getTemplateParameter());
		return map;
	}

}
