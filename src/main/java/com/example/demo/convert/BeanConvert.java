package com.example.demo.convert;

import java.util.List;

public interface BeanConvert<Vo,Bean>{
	Bean convertToBean(Vo vo);
	Vo convertToVo(Bean bean);
	List<Vo> convertToVoList(List<Bean> users);
	
}
