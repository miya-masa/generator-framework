package jp.co.myms.generate.core.name;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * テンプレートファイルと出力先ファイル名のマッピング.
 * 
 * @author myms
 *
 */
public class NameMappings {

	/** テンプレートファイルを出力ファイル名のマッピング. */
	private Map<File, String> templateNameMap = new HashMap<>();

	/**
	 * テンプレートファイルから、該当するファイル名を取得する.
	 * 
	 * @param tempalteFile テンプレートファイル.
	 * @return 該当するファイル名、存在しない場合はnull
	 */
	public String getFileName(File tempalteFile) {
		return templateNameMap.get(tempalteFile);
	}

	/**
	 * テンプレートファイルから、該当するファイル名を取得する.
	 * 
	 * @param tempalteFile テンプレートファイル.
	 * @param defaultName 存在しない場合のデフォルト値
	 * @return 該当するファイル名、存在しない場合はdefaultName
	 */
	public String getFileName(File tempalteFile, String defaultName) {
		String name = getFileName(tempalteFile);
		if (name == null) {
			return defaultName;
		}
		return name;
	}

	/**
	 * マッピングを追加する.
	 * 
	 * @param templateFile テンプレートファイル
	 * @param fileName 該当するファイル名
	 */
	public void put(File templateFile, String fileName) {
		templateNameMap.put(templateFile, fileName);
	}

}
