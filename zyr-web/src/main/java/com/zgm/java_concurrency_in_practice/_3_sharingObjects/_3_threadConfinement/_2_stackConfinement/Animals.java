/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online at
 * http://www.etong.com/
 */
package com.zgm.java_concurrency_in_practice._3_sharingObjects._3_threadConfinement._2_stackConfinement;

import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * 
 * @author 周光明 Exp
 * @version $FileName: Animals.java $Date: Apr 16, 2013 9:12:43 AM -0400 2013
 * @since 1.0
 * 
 */
public class Animals {
	/**
	 * 方舟
	 */
	Ark ark;
	/**
	 * 物种
	 */
    Species species;
    /**
     * 性别
     */
    Gender gender;

    /**
     * 基本类型的局部变量与引用变量线程封闭性
     * 
     * @param candidates
     * @return
     */
    public int loadTheArk(Collection<Animal> candidates) {
        SortedSet<Animal> animals;
        int numPairs = 0;
        Animal candidate = null;

        // animals confined to method, don't let them escape!
        animals = new TreeSet<Animal>(new SpeciesGenderComparator());
        animals.addAll(candidates);
        for (Animal a : animals) {
            if (candidate == null || !candidate.isPotentialMate(a))
                candidate = a;
            else {
                ark.load(new AnimalPair(candidate, a));
                ++numPairs;
                candidate = null;
            }
        }
        return numPairs;
    }


    class Animal {
        Species species;
        Gender gender;

        public boolean isPotentialMate(Animal other) {
            return species == other.species && gender != other.gender;
        }
    }

    enum Species {
        AARDVARK, BENGAL_TIGER, CARIBOU, DINGO, ELEPHANT, FROG, GNU, HYENA,
        IGUANA, JAGUAR, KIWI, LEOPARD, MASTADON, NEWT, OCTOPUS,
        PIRANHA, QUETZAL, RHINOCEROS, SALAMANDER, THREE_TOED_SLOTH,
        UNICORN, VIPER, WEREWOLF, XANTHUS_HUMMINBIRD, YAK, ZEBRA
    }

    enum Gender {
        MALE, FEMALE
    }

    class AnimalPair {
        private final Animal one, two;

        public AnimalPair(Animal one, Animal two) {
            this.one = one;
            this.two = two;
        }
    }

    class SpeciesGenderComparator implements Comparator<Animal> {
        public int compare(Animal one, Animal two) {
            int speciesCompare = one.species.compareTo(two.species);
            return (speciesCompare != 0)
                    ? speciesCompare
                    : one.gender.compareTo(two.gender);
        }
    }

    class Ark {
        private final Set<AnimalPair> loadedAnimals = new HashSet<AnimalPair>();

        public void load(AnimalPair pair) {
            loadedAnimals.add(pair);
        }
    }
}
