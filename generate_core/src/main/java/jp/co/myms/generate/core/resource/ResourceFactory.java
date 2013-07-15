package jp.co.myms.generate.core.resource;


/**
 * リソースを生成するためのファクトリクラス.
 * 
 * @author myms
 * 
 */
public interface ResourceFactory {

	ResourceWrapper createResource(String path);

	ResourceWrapper createResourceFromClasspath(String path);

	ResourceWrapper createResource(String outputDir, String computeOutputFileNames);

}
