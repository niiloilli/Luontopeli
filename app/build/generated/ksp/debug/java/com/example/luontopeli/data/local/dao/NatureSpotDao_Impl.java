package com.example.luontopeli.data.local.dao;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.annotation.NonNull;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.luontopeli.data.local.entity.NatureSpot;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Float;
import java.lang.Long;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.processing.Generated;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class NatureSpotDao_Impl implements NatureSpotDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<NatureSpot> __insertionAdapterOfNatureSpot;

  private final EntityDeletionOrUpdateAdapter<NatureSpot> __deletionAdapterOfNatureSpot;

  private final SharedSQLiteStatement __preparedStmtOfMarkSynced;

  public NatureSpotDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfNatureSpot = new EntityInsertionAdapter<NatureSpot>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `nature_spots` (`id`,`name`,`latitude`,`longitude`,`imageLocalPath`,`imageFirebaseUrl`,`plantLabel`,`confidence`,`userId`,`timestamp`,`synced`) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final NatureSpot entity) {
        statement.bindString(1, entity.getId());
        statement.bindString(2, entity.getName());
        statement.bindDouble(3, entity.getLatitude());
        statement.bindDouble(4, entity.getLongitude());
        if (entity.getImageLocalPath() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getImageLocalPath());
        }
        if (entity.getImageFirebaseUrl() == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, entity.getImageFirebaseUrl());
        }
        if (entity.getPlantLabel() == null) {
          statement.bindNull(7);
        } else {
          statement.bindString(7, entity.getPlantLabel());
        }
        if (entity.getConfidence() == null) {
          statement.bindNull(8);
        } else {
          statement.bindDouble(8, entity.getConfidence());
        }
        if (entity.getUserId() == null) {
          statement.bindNull(9);
        } else {
          statement.bindString(9, entity.getUserId());
        }
        statement.bindLong(10, entity.getTimestamp());
        final int _tmp = entity.getSynced() ? 1 : 0;
        statement.bindLong(11, _tmp);
      }
    };
    this.__deletionAdapterOfNatureSpot = new EntityDeletionOrUpdateAdapter<NatureSpot>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `nature_spots` WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final NatureSpot entity) {
        statement.bindString(1, entity.getId());
      }
    };
    this.__preparedStmtOfMarkSynced = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "UPDATE nature_spots SET synced = 1, imageFirebaseUrl = ? WHERE id = ?";
        return _query;
      }
    };
  }

  @Override
  public Object insert(final NatureSpot spot, final Continuation<? super Long> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Long>() {
      @Override
      @NonNull
      public Long call() throws Exception {
        __db.beginTransaction();
        try {
          final Long _result = __insertionAdapterOfNatureSpot.insertAndReturnId(spot);
          __db.setTransactionSuccessful();
          return _result;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object delete(final NatureSpot spot, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfNatureSpot.handle(spot);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object markSynced(final String id, final String url,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfMarkSynced.acquire();
        int _argIndex = 1;
        _stmt.bindString(_argIndex, url);
        _argIndex = 2;
        _stmt.bindString(_argIndex, id);
        try {
          __db.beginTransaction();
          try {
            _stmt.executeUpdateDelete();
            __db.setTransactionSuccessful();
            return Unit.INSTANCE;
          } finally {
            __db.endTransaction();
          }
        } finally {
          __preparedStmtOfMarkSynced.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Flow<List<NatureSpot>> getAllSpots() {
    final String _sql = "SELECT * FROM nature_spots ORDER BY timestamp DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"nature_spots"}, new Callable<List<NatureSpot>>() {
      @Override
      @NonNull
      public List<NatureSpot> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfLatitude = CursorUtil.getColumnIndexOrThrow(_cursor, "latitude");
          final int _cursorIndexOfLongitude = CursorUtil.getColumnIndexOrThrow(_cursor, "longitude");
          final int _cursorIndexOfImageLocalPath = CursorUtil.getColumnIndexOrThrow(_cursor, "imageLocalPath");
          final int _cursorIndexOfImageFirebaseUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "imageFirebaseUrl");
          final int _cursorIndexOfPlantLabel = CursorUtil.getColumnIndexOrThrow(_cursor, "plantLabel");
          final int _cursorIndexOfConfidence = CursorUtil.getColumnIndexOrThrow(_cursor, "confidence");
          final int _cursorIndexOfUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "userId");
          final int _cursorIndexOfTimestamp = CursorUtil.getColumnIndexOrThrow(_cursor, "timestamp");
          final int _cursorIndexOfSynced = CursorUtil.getColumnIndexOrThrow(_cursor, "synced");
          final List<NatureSpot> _result = new ArrayList<NatureSpot>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final NatureSpot _item;
            final String _tmpId;
            _tmpId = _cursor.getString(_cursorIndexOfId);
            final String _tmpName;
            _tmpName = _cursor.getString(_cursorIndexOfName);
            final double _tmpLatitude;
            _tmpLatitude = _cursor.getDouble(_cursorIndexOfLatitude);
            final double _tmpLongitude;
            _tmpLongitude = _cursor.getDouble(_cursorIndexOfLongitude);
            final String _tmpImageLocalPath;
            if (_cursor.isNull(_cursorIndexOfImageLocalPath)) {
              _tmpImageLocalPath = null;
            } else {
              _tmpImageLocalPath = _cursor.getString(_cursorIndexOfImageLocalPath);
            }
            final String _tmpImageFirebaseUrl;
            if (_cursor.isNull(_cursorIndexOfImageFirebaseUrl)) {
              _tmpImageFirebaseUrl = null;
            } else {
              _tmpImageFirebaseUrl = _cursor.getString(_cursorIndexOfImageFirebaseUrl);
            }
            final String _tmpPlantLabel;
            if (_cursor.isNull(_cursorIndexOfPlantLabel)) {
              _tmpPlantLabel = null;
            } else {
              _tmpPlantLabel = _cursor.getString(_cursorIndexOfPlantLabel);
            }
            final Float _tmpConfidence;
            if (_cursor.isNull(_cursorIndexOfConfidence)) {
              _tmpConfidence = null;
            } else {
              _tmpConfidence = _cursor.getFloat(_cursorIndexOfConfidence);
            }
            final String _tmpUserId;
            if (_cursor.isNull(_cursorIndexOfUserId)) {
              _tmpUserId = null;
            } else {
              _tmpUserId = _cursor.getString(_cursorIndexOfUserId);
            }
            final long _tmpTimestamp;
            _tmpTimestamp = _cursor.getLong(_cursorIndexOfTimestamp);
            final boolean _tmpSynced;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfSynced);
            _tmpSynced = _tmp != 0;
            _item = new NatureSpot(_tmpId,_tmpName,_tmpLatitude,_tmpLongitude,_tmpImageLocalPath,_tmpImageFirebaseUrl,_tmpPlantLabel,_tmpConfidence,_tmpUserId,_tmpTimestamp,_tmpSynced);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Flow<List<NatureSpot>> getSpotsWithLocation() {
    final String _sql = "SELECT * FROM nature_spots WHERE latitude != 0.0";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"nature_spots"}, new Callable<List<NatureSpot>>() {
      @Override
      @NonNull
      public List<NatureSpot> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfLatitude = CursorUtil.getColumnIndexOrThrow(_cursor, "latitude");
          final int _cursorIndexOfLongitude = CursorUtil.getColumnIndexOrThrow(_cursor, "longitude");
          final int _cursorIndexOfImageLocalPath = CursorUtil.getColumnIndexOrThrow(_cursor, "imageLocalPath");
          final int _cursorIndexOfImageFirebaseUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "imageFirebaseUrl");
          final int _cursorIndexOfPlantLabel = CursorUtil.getColumnIndexOrThrow(_cursor, "plantLabel");
          final int _cursorIndexOfConfidence = CursorUtil.getColumnIndexOrThrow(_cursor, "confidence");
          final int _cursorIndexOfUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "userId");
          final int _cursorIndexOfTimestamp = CursorUtil.getColumnIndexOrThrow(_cursor, "timestamp");
          final int _cursorIndexOfSynced = CursorUtil.getColumnIndexOrThrow(_cursor, "synced");
          final List<NatureSpot> _result = new ArrayList<NatureSpot>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final NatureSpot _item;
            final String _tmpId;
            _tmpId = _cursor.getString(_cursorIndexOfId);
            final String _tmpName;
            _tmpName = _cursor.getString(_cursorIndexOfName);
            final double _tmpLatitude;
            _tmpLatitude = _cursor.getDouble(_cursorIndexOfLatitude);
            final double _tmpLongitude;
            _tmpLongitude = _cursor.getDouble(_cursorIndexOfLongitude);
            final String _tmpImageLocalPath;
            if (_cursor.isNull(_cursorIndexOfImageLocalPath)) {
              _tmpImageLocalPath = null;
            } else {
              _tmpImageLocalPath = _cursor.getString(_cursorIndexOfImageLocalPath);
            }
            final String _tmpImageFirebaseUrl;
            if (_cursor.isNull(_cursorIndexOfImageFirebaseUrl)) {
              _tmpImageFirebaseUrl = null;
            } else {
              _tmpImageFirebaseUrl = _cursor.getString(_cursorIndexOfImageFirebaseUrl);
            }
            final String _tmpPlantLabel;
            if (_cursor.isNull(_cursorIndexOfPlantLabel)) {
              _tmpPlantLabel = null;
            } else {
              _tmpPlantLabel = _cursor.getString(_cursorIndexOfPlantLabel);
            }
            final Float _tmpConfidence;
            if (_cursor.isNull(_cursorIndexOfConfidence)) {
              _tmpConfidence = null;
            } else {
              _tmpConfidence = _cursor.getFloat(_cursorIndexOfConfidence);
            }
            final String _tmpUserId;
            if (_cursor.isNull(_cursorIndexOfUserId)) {
              _tmpUserId = null;
            } else {
              _tmpUserId = _cursor.getString(_cursorIndexOfUserId);
            }
            final long _tmpTimestamp;
            _tmpTimestamp = _cursor.getLong(_cursorIndexOfTimestamp);
            final boolean _tmpSynced;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfSynced);
            _tmpSynced = _tmp != 0;
            _item = new NatureSpot(_tmpId,_tmpName,_tmpLatitude,_tmpLongitude,_tmpImageLocalPath,_tmpImageFirebaseUrl,_tmpPlantLabel,_tmpConfidence,_tmpUserId,_tmpTimestamp,_tmpSynced);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Object getUnsyncedSpots(final Continuation<? super List<NatureSpot>> $completion) {
    final String _sql = "SELECT * FROM nature_spots WHERE synced = 0";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<NatureSpot>>() {
      @Override
      @NonNull
      public List<NatureSpot> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfLatitude = CursorUtil.getColumnIndexOrThrow(_cursor, "latitude");
          final int _cursorIndexOfLongitude = CursorUtil.getColumnIndexOrThrow(_cursor, "longitude");
          final int _cursorIndexOfImageLocalPath = CursorUtil.getColumnIndexOrThrow(_cursor, "imageLocalPath");
          final int _cursorIndexOfImageFirebaseUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "imageFirebaseUrl");
          final int _cursorIndexOfPlantLabel = CursorUtil.getColumnIndexOrThrow(_cursor, "plantLabel");
          final int _cursorIndexOfConfidence = CursorUtil.getColumnIndexOrThrow(_cursor, "confidence");
          final int _cursorIndexOfUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "userId");
          final int _cursorIndexOfTimestamp = CursorUtil.getColumnIndexOrThrow(_cursor, "timestamp");
          final int _cursorIndexOfSynced = CursorUtil.getColumnIndexOrThrow(_cursor, "synced");
          final List<NatureSpot> _result = new ArrayList<NatureSpot>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final NatureSpot _item;
            final String _tmpId;
            _tmpId = _cursor.getString(_cursorIndexOfId);
            final String _tmpName;
            _tmpName = _cursor.getString(_cursorIndexOfName);
            final double _tmpLatitude;
            _tmpLatitude = _cursor.getDouble(_cursorIndexOfLatitude);
            final double _tmpLongitude;
            _tmpLongitude = _cursor.getDouble(_cursorIndexOfLongitude);
            final String _tmpImageLocalPath;
            if (_cursor.isNull(_cursorIndexOfImageLocalPath)) {
              _tmpImageLocalPath = null;
            } else {
              _tmpImageLocalPath = _cursor.getString(_cursorIndexOfImageLocalPath);
            }
            final String _tmpImageFirebaseUrl;
            if (_cursor.isNull(_cursorIndexOfImageFirebaseUrl)) {
              _tmpImageFirebaseUrl = null;
            } else {
              _tmpImageFirebaseUrl = _cursor.getString(_cursorIndexOfImageFirebaseUrl);
            }
            final String _tmpPlantLabel;
            if (_cursor.isNull(_cursorIndexOfPlantLabel)) {
              _tmpPlantLabel = null;
            } else {
              _tmpPlantLabel = _cursor.getString(_cursorIndexOfPlantLabel);
            }
            final Float _tmpConfidence;
            if (_cursor.isNull(_cursorIndexOfConfidence)) {
              _tmpConfidence = null;
            } else {
              _tmpConfidence = _cursor.getFloat(_cursorIndexOfConfidence);
            }
            final String _tmpUserId;
            if (_cursor.isNull(_cursorIndexOfUserId)) {
              _tmpUserId = null;
            } else {
              _tmpUserId = _cursor.getString(_cursorIndexOfUserId);
            }
            final long _tmpTimestamp;
            _tmpTimestamp = _cursor.getLong(_cursorIndexOfTimestamp);
            final boolean _tmpSynced;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfSynced);
            _tmpSynced = _tmp != 0;
            _item = new NatureSpot(_tmpId,_tmpName,_tmpLatitude,_tmpLongitude,_tmpImageLocalPath,_tmpImageFirebaseUrl,_tmpPlantLabel,_tmpConfidence,_tmpUserId,_tmpTimestamp,_tmpSynced);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
