package com.example.socialmediaintegration.di;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Custom scope for all activities
 */
@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface PerActivity {

}
