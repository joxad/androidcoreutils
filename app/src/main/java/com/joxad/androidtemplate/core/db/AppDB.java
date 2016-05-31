package com.joxad.androidtemplate.core.db;

import com.raizlabs.android.dbflow.annotation.Database;

@Database(name = AppDB.NAME, version = AppDB.VERSION)
public class AppDB {

  public static final String NAME = "AppDB";

  public static final int VERSION = 1;
}