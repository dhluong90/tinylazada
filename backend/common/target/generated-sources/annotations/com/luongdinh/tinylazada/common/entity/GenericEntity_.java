package com.luongdinh.tinylazada.common.entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GenericEntity.class)
public abstract class GenericEntity_ {

	public static volatile SingularAttribute<GenericEntity, Date> createdDate;
	public static volatile SingularAttribute<GenericEntity, String> updatedBy;
	public static volatile SingularAttribute<GenericEntity, Boolean> deleted;
	public static volatile SingularAttribute<GenericEntity, String> createdBy;
	public static volatile SingularAttribute<GenericEntity, Date> updatedDate;

	public static final String CREATED_DATE = "createdDate";
	public static final String UPDATED_BY = "updatedBy";
	public static final String DELETED = "deleted";
	public static final String CREATED_BY = "createdBy";
	public static final String UPDATED_DATE = "updatedDate";

}

