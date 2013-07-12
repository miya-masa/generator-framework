package jp.co.myms.generate.core.template;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * @author myms
 * 
 */
public class VariableMap {

	/** 変数Map. */
	private final Map<String, Object> map = new HashMap<String, Object>();

	/**
	 * 変数を追加する.
	 * 
	 * @param key テンプレートで使用する変数名
	 * @param value 値
	 */
	public void put(String key, Object value) {
		map.put(key, value);
	}

	/**
	 * エントリーを取得する.
	 * 
	 * @return エントリー
	 */
	public Set<Entry<String, Object>> entrySet() {
		return map.entrySet();
	}
}
