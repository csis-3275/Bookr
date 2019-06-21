/**
 * 
 */
package com.csis3275.Entities;

import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="subscriptions")

/**
 * @author Ayodeji Tolu-ojo 300249754
 *
 */

public class Subscription {
	@Id
	@GeneratedValue
	private int _id;
}
