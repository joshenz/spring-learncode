package spring.learn.ioc.filter;

import org.springframework.core.io.Resource;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;

/**
 * 类的功能描述
 *
 * @author ZHENG
 * @version 1.0
 * @date 2020/3/13 10:00
 */
public class MyFilter implements TypeFilter {
	@Override
	public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
		//metadataReader 当前扫描的类信息
		//获取当前类注解信息
		AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();
		//类信息
		ClassMetadata classMetadata = metadataReader.getClassMetadata();
		//资源信息 类路径等
		Resource resource = metadataReader.getResource();

		//metadataReaderFactory 类工厂  获取其它类信息
		System.out.println(classMetadata.getClassName());
		return classMetadata.getClassName().contains("er");
	}
}
