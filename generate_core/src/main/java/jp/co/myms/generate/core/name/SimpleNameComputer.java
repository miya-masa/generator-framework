package jp.co.myms.generate.core.name;

import java.io.File;

import jp.co.myms.generate.core.param.GeneratorParameter;

import org.apache.commons.io.FilenameUtils;

public class SimpleNameComputer<T> implements NameComputer<T> {

	@Override
	public NameMappings computeOutputFileNames(File[] templateFiles, GeneratorParameter<T> parameter) {
		NameMappings mappings = new NameMappings();
		for (File file : templateFiles) {
			String outputFileName = FilenameUtils.getBaseName(file.getPath()) + ".txt";
			mappings.put(file, outputFileName);
		}
		return mappings;
	}

}
