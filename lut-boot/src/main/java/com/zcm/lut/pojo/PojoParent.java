package com.zcm.lut.pojo;

import java.io.Serializable;

//要想使用redis存对象，一定要让实体类实现Serializable接口，否则会报错
public class PojoParent implements Serializable{

	private static final long serialVersionUID = 1L;

}
