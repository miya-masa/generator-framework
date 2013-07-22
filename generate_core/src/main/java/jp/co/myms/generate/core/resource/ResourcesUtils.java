package jp.co.myms.generate.core.resource;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.io.FilenameUtils;

/**
 * リソース関連のユーティリティ.<br>
 * リソースファクトリクラスを設定して使用する.
 * 
 * @author myms
 */
@SuppressWarnings("unchecked")
public final class ResourcesUtils {

	/** リソースファクトリクラス. */
	private static Class<? extends ResourceFactory> resourceFactoryClass;

	static {
		try {
			resourceFactoryClass = (Class<? extends ResourceFactory>) Class.forName("jp.co.myms.generate.core.resource.filesystem.SystemResourceFactory");
		} catch (ClassNotFoundException e) {
			throw new AssertionError();
		}
	}

	/**
	 * リソースファクトリインスタンスを取得する.
	 * 
	 * @return リソースファクトリ.
	 */
	public static ResourceFactory createFactory() {
		try {
			return (ResourceFactory) resourceFactoryClass.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			throw new AssertionError();
		}
	}

	/**
	 * リソース内のファイルを取得する.
	 * 
	 * @param dir ディレクトリ
	 * @param extensions 拡張子
	 * @param recursive 再帰的に検索するかどうか
	 * @return リソースのコレクション
	 */
	public static Collection<ResourceWrapper> listFiles(ResourceWrapper dir, String[] extensions, boolean recursive) {
		List<ResourceWrapper> resourceWrappers = new ArrayList<>();
		if (dir instanceof DirectoryWrapper) {
			FileWrapper[] fileWrappers = ((DirectoryWrapper) dir).listFiles(recursive);
			for (FileWrapper fileWrapper : fileWrappers) {
				if (FilenameUtils.isExtension(fileWrapper.getName(), extensions)) {
					resourceWrappers.add(fileWrapper);
				}
			}
		}
		return resourceWrappers;
	}

	/**
	 * リソースファクトリクラスを設定する.
	 * 
	 * @param resourceFactoryClass リソースファクトリ
	 */
	public static void setResourceFactoryClass(Class<? extends ResourceFactory> resourceFactoryClass) {
		ResourcesUtils.resourceFactoryClass = resourceFactoryClass;
	}

	/**
	 * コンストラクタ.
	 */
	private ResourcesUtils() {
	}

}
