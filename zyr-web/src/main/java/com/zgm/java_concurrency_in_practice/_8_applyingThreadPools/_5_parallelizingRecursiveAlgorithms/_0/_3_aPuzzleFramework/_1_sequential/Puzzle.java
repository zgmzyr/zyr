/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online 
 */
package com.zgm.java_concurrency_in_practice._8_applyingThreadPools._5_parallelizingRecursiveAlgorithms._0._3_aPuzzleFramework._1_sequential;

import java.util.Set;

/**
 * 
 * @author 周光明 Exp
 * @version $FileName: Puzzle.java $Date: May 24, 2013 3:17:29 PM -0400 2013
 * @since 1.0
 * 
 */
public interface Puzzle<P, M> {
	P initialPosition();

	boolean isGoal(P position);

	Set<M> legalMoves(P position);

	P move(P position, M move);
}
