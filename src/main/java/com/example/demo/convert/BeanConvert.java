package com.example.demo.convert;

public interface BeanConvert<Vo,Bean>{
	Bean convertToBean(Vo vo);
	Vo convertToVo(Bean bean);
}
