package com.rockwellcollins.atc.limp.translate.lustre.limp2lustre;

import com.rockwellcollins.atc.limp.LocalProcedure;
import com.rockwellcollins.atc.limp.translate.basicblocks.limp.AppendInitState;
import com.rockwellcollins.atc.limp.translate.basicblocks.limp.BasicBlock;
import com.rockwellcollins.atc.limp.translate.basicblocks.limp.ComputeBasicBlocks;
import com.rockwellcollins.atc.limp.translate.basicblocks.limp.RemoveTrivialBasicBlocks;

public class GenerateCFG {
	
	public static BasicBlock get(LocalProcedure lp) {
		BasicBlock first = ComputeBasicBlocks.computeBasicBlocks(lp);
		first = RemoveTrivialBasicBlocks.remove(first);
		first = AppendInitState.append(first);
		
		return first;
	}
}
