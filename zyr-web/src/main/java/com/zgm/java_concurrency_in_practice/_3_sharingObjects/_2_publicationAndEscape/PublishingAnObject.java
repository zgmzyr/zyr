/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online at
 * http://www.etong.com/
 */
package com.zgm.java_concurrency_in_practice._3_sharingObjects._2_publicationAndEscape;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author 周光明 Exp
 * @version $FileName: PublishingAnObject.java $Date: Apr 15, 2013 2:56:47 PM -0400 2013
 * @since 1.0
 * 
 */
public class PublishingAnObject {
	public static Set<Secret> knownSecrets;

	public void initialize() {
	    knownSecrets = new HashSet<Secret>();
	}

}

class Secret {
	
}
