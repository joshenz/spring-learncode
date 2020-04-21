package learn.spring.com.filter;

import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;

/**
 * 类的功能描述
 *
 * @author ZHENG
 * @version 1.0
 * @date 2020/3/14 16:02
 */
public class MyFilter implements TypeFilter {
	@Override
	public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
		String className = metadataReader.getAnnotationMetadata().getClassName();
		System.out.println("...Ioc is load "+className+"...");
		return true;
	}
}
