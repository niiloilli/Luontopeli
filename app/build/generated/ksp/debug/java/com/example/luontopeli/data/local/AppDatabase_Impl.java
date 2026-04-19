package com.example.luontopeli.data.local;

import androidx.annotation.NonNull;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomOpenHelper;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import com.example.luontopeli.data.local.dao.NatureSpotDao;
import com.example.luontopeli.data.local.dao.NatureSpotDao_Impl;
import com.example.luontopeli.data.local.dao.WalkSessionDao;
import com.example.luontopeli.data.local.dao.WalkSessionDao_Impl;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.processing.Generated;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class AppDatabase_Impl extends AppDatabase {
  private volatile NatureSpotDao _natureSpotDao;

  private volatile WalkSessionDao _walkSessionDao;

  @Override
  @NonNull
  protected SupportSQLiteOpenHelper createOpenHelper(@NonNull final DatabaseConfiguration config) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(config, new RoomOpenHelper.Delegate(2) {
      @Override
      public void createAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS `nature_spots` (`id` TEXT NOT NULL, `name` TEXT NOT NULL, `latitude` REAL NOT NULL, `longitude` REAL NOT NULL, `imageLocalPath` TEXT, `imageFirebaseUrl` TEXT, `plantLabel` TEXT, `confidence` REAL, `userId` TEXT, `timestamp` INTEGER NOT NULL, `synced` INTEGER NOT NULL, PRIMARY KEY(`id`))");
        db.execSQL("CREATE TABLE IF NOT EXISTS `walk_sessions` (`id` TEXT NOT NULL, `startTime` INTEGER NOT NULL, `endTime` INTEGER, `stepCount` INTEGER NOT NULL, `distanceMeters` REAL NOT NULL, `spotsFound` INTEGER NOT NULL, `isActive` INTEGER NOT NULL, PRIMARY KEY(`id`))");
        db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'a261f3c690ed320c73b7d1ddc820c2f6')");
      }

      @Override
      public void dropAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS `nature_spots`");
        db.execSQL("DROP TABLE IF EXISTS `walk_sessions`");
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onDestructiveMigration(db);
          }
        }
      }

      @Override
      public void onCreate(@NonNull final SupportSQLiteDatabase db) {
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onCreate(db);
          }
        }
      }

      @Override
      public void onOpen(@NonNull final SupportSQLiteDatabase db) {
        mDatabase = db;
        internalInitInvalidationTracker(db);
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onOpen(db);
          }
        }
      }

      @Override
      public void onPreMigrate(@NonNull final SupportSQLiteDatabase db) {
        DBUtil.dropFtsSyncTriggers(db);
      }

      @Override
      public void onPostMigrate(@NonNull final SupportSQLiteDatabase db) {
      }

      @Override
      @NonNull
      public RoomOpenHelper.ValidationResult onValidateSchema(
          @NonNull final SupportSQLiteDatabase db) {
        final HashMap<String, TableInfo.Column> _columnsNatureSpots = new HashMap<String, TableInfo.Column>(11);
        _columnsNatureSpots.put("id", new TableInfo.Column("id", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsNatureSpots.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsNatureSpots.put("latitude", new TableInfo.Column("latitude", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsNatureSpots.put("longitude", new TableInfo.Column("longitude", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsNatureSpots.put("imageLocalPath", new TableInfo.Column("imageLocalPath", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsNatureSpots.put("imageFirebaseUrl", new TableInfo.Column("imageFirebaseUrl", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsNatureSpots.put("plantLabel", new TableInfo.Column("plantLabel", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsNatureSpots.put("confidence", new TableInfo.Column("confidence", "REAL", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsNatureSpots.put("userId", new TableInfo.Column("userId", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsNatureSpots.put("timestamp", new TableInfo.Column("timestamp", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsNatureSpots.put("synced", new TableInfo.Column("synced", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysNatureSpots = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesNatureSpots = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoNatureSpots = new TableInfo("nature_spots", _columnsNatureSpots, _foreignKeysNatureSpots, _indicesNatureSpots);
        final TableInfo _existingNatureSpots = TableInfo.read(db, "nature_spots");
        if (!_infoNatureSpots.equals(_existingNatureSpots)) {
          return new RoomOpenHelper.ValidationResult(false, "nature_spots(com.example.luontopeli.data.local.entity.NatureSpot).\n"
                  + " Expected:\n" + _infoNatureSpots + "\n"
                  + " Found:\n" + _existingNatureSpots);
        }
        final HashMap<String, TableInfo.Column> _columnsWalkSessions = new HashMap<String, TableInfo.Column>(7);
        _columnsWalkSessions.put("id", new TableInfo.Column("id", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWalkSessions.put("startTime", new TableInfo.Column("startTime", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWalkSessions.put("endTime", new TableInfo.Column("endTime", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWalkSessions.put("stepCount", new TableInfo.Column("stepCount", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWalkSessions.put("distanceMeters", new TableInfo.Column("distanceMeters", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWalkSessions.put("spotsFound", new TableInfo.Column("spotsFound", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWalkSessions.put("isActive", new TableInfo.Column("isActive", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysWalkSessions = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesWalkSessions = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoWalkSessions = new TableInfo("walk_sessions", _columnsWalkSessions, _foreignKeysWalkSessions, _indicesWalkSessions);
        final TableInfo _existingWalkSessions = TableInfo.read(db, "walk_sessions");
        if (!_infoWalkSessions.equals(_existingWalkSessions)) {
          return new RoomOpenHelper.ValidationResult(false, "walk_sessions(com.example.luontopeli.data.local.entity.WalkSession).\n"
                  + " Expected:\n" + _infoWalkSessions + "\n"
                  + " Found:\n" + _existingWalkSessions);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "a261f3c690ed320c73b7d1ddc820c2f6", "96542a14e34ac8fad388fbdfeeebead1");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(config.context).name(config.name).callback(_openCallback).build();
    final SupportSQLiteOpenHelper _helper = config.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  @NonNull
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    final HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "nature_spots","walk_sessions");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `nature_spots`");
      _db.execSQL("DELETE FROM `walk_sessions`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  @NonNull
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(NatureSpotDao.class, NatureSpotDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(WalkSessionDao.class, WalkSessionDao_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  @NonNull
  public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
    final HashSet<Class<? extends AutoMigrationSpec>> _autoMigrationSpecsSet = new HashSet<Class<? extends AutoMigrationSpec>>();
    return _autoMigrationSpecsSet;
  }

  @Override
  @NonNull
  public List<Migration> getAutoMigrations(
      @NonNull final Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecs) {
    final List<Migration> _autoMigrations = new ArrayList<Migration>();
    return _autoMigrations;
  }

  @Override
  public NatureSpotDao natureSpotDao() {
    if (_natureSpotDao != null) {
      return _natureSpotDao;
    } else {
      synchronized(this) {
        if(_natureSpotDao == null) {
          _natureSpotDao = new NatureSpotDao_Impl(this);
        }
        return _natureSpotDao;
      }
    }
  }

  @Override
  public WalkSessionDao walkSessionDao() {
    if (_walkSessionDao != null) {
      return _walkSessionDao;
    } else {
      synchronized(this) {
        if(_walkSessionDao == null) {
          _walkSessionDao = new WalkSessionDao_Impl(this);
        }
        return _walkSessionDao;
      }
    }
  }
}
