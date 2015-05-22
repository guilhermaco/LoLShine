package br.com.unibratec.lolshine.data;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

public class GamesProvider extends ContentProvider {

    public static final int GAME = 100;
    public static final int PLAYER = 200;

    private static UriMatcher sUriMatcher = buildUriMatcher();
    private GamesDbHelper mGamesDbHelper;

    private static UriMatcher buildUriMatcher(){
        final UriMatcher uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        final String authority = GameContract.CONTENT_AUTHORITY;

        uriMatcher.addURI(authority, GameContract.PATH_GAME,
                GAME); // 100
        uriMatcher.addURI(authority, GameContract.PATH_PLAYER,
                PLAYER); // 200

        return uriMatcher;
    }

    public GamesProvider() {
    }



    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        SQLiteDatabase db = mGamesDbHelper.getWritableDatabase();
        int affectedRows = 0;
        final int uriType = sUriMatcher.match(uri);
        if(selection == null){selection = "1";}
        switch (uriType) {
            case PLAYER: {
                affectedRows = db.delete(GameContract.PlayerEntry.TABLE_NAME,
                        selection, selectionArgs);
                break;
            }
            case GAME: {
                affectedRows = db.delete(GameContract.GameEntry.TABLE_NAME,
                        selection, selectionArgs);
                break;
            }
            default:
                throw new UnsupportedOperationException("Unknown uri: "+ uri);
        }
        if (affectedRows != 0){
            getContext().getContentResolver().notifyChange(uri, null);
        }
        return affectedRows;
    }

    @Override
    public String getType(Uri uri) {
        // TODO: Implement this to handle requests for the MIME type of the data
        // at the given URI.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        Uri insertedUri = null;
        final int uriType = sUriMatcher.match(uri);
        SQLiteDatabase db = mGamesDbHelper.getWritableDatabase();

        switch (uriType){
            case GAME: {
                long _id = db.insert(
                        GameContract.GameEntry.TABLE_NAME, null, values);
                if (_id != -1){
                    insertedUri =
                            GameContract.GameEntry.buildGameUri(_id);
                } else {
                    throw new SQLException("Fail to insert game.");
                }
                break;
            }
            case PLAYER:
                long _id = db.insert(
                        GameContract.PlayerEntry.TABLE_NAME, null, values);
                if (_id != -1){
                    insertedUri = GameContract.PlayerEntry.buildPlayerUri(_id);
                } else {
                    throw new SQLException("Fail to insert player.");
                }
                break;
        }

        getContext().getContentResolver().notifyChange(uri, null);
        return insertedUri;
    }

    @Override
    public boolean onCreate() {
        mGamesDbHelper = new GamesDbHelper(getContext());
        return true;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {
        Cursor retCursor = null;
        switch (sUriMatcher.match(uri)) {
            case PLAYER: {
                retCursor = mGamesDbHelper.getReadableDatabase().query(
                        GameContract.PlayerEntry.TABLE_NAME,
                        projection,
                        selection,
                        selectionArgs,
                        null,
                        null,
                        sortOrder);
                break;
            }
            case GAME: {
                retCursor = mGamesDbHelper.getReadableDatabase().query(
                        GameContract.GameEntry.TABLE_NAME,
                        projection,
                        selection,
                        selectionArgs,
                        null,
                        null,
                        sortOrder);
                break;
            }
            default:
                throw new UnsupportedOperationException("Unknown uri: " + uri);
        }
        retCursor.setNotificationUri(getContext().getContentResolver(), uri);
        return retCursor;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {
        SQLiteDatabase db = mGamesDbHelper.getWritableDatabase();
        int affectedRows = 0;
        final int uriType = sUriMatcher.match(uri);
        switch (uriType) {
            case PLAYER: {
                affectedRows = db.update(GameContract.PlayerEntry.TABLE_NAME,
                        values, selection, selectionArgs);
                break;
            }
            case GAME: {
                affectedRows = db.update(GameContract.GameEntry.TABLE_NAME,
                        values, selection, selectionArgs);
                break;
            }
            default:
                throw new UnsupportedOperationException("Unknown uri: "+ uri);
        }
        if (affectedRows != 0){
            getContext().getContentResolver().notifyChange(uri, null);
        }
        return affectedRows;
    }
}
