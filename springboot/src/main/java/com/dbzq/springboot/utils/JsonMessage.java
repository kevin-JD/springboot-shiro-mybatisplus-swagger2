package com.dbzq.springboot.utils;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * @author yuld
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class JsonMessage {

	private Date time = new Date();
	private boolean success;
	private Object data;


}