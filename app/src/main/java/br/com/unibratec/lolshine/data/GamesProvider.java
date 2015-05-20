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
        // Implement this to handle requests to delete one or more rows.
        throw new UnsupportedOperationException("Not yet implemented");
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
        // TODO: Implement this to handle query requests from clients.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {
        // TODO: Implement this to handle requests to update one or more rows.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
