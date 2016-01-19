package com.rockwellcollins.atc.limp.translate.lustre.limp2lustre;

import java.util.ArrayList;
import java.util.List;

public class MangleList extends ArrayList<Pair<List<String>,String>>  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 217117932624965348L;

	public void addSingleToMangleList(String id, String toId){
		if (!id.equals(toId)){
			List<String> li = new ArrayList<>();
			li.add(id);			
			this.add(new Pair<List<String>,String>(li, toId));
		}
	}

}
