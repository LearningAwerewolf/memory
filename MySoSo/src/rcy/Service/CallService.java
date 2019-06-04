package rcy.Service;

import rcy.Basics.MobileCard;

public interface CallService {
	public int call(int minCount, MobileCard card) throws Exception;
}
