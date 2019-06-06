package cn.soso.service;

import cn.soso.entity.MobileCard;

/**
 * 上网服务
 * @author 
 *
 */
public interface NetService {
	//上网
     public int netPlay(int flow,MobileCard card) throws Exception;
}
