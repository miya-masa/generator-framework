package jp.co.myms.generate.core.resource;

public interface DirectoryWrapper extends ResourceWrapper {

	/**
	 * @param recursive
	 */
	FileWrapper[] listFiles(boolean recursive);

}
