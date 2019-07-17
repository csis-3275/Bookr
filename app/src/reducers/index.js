import { combineReducers } from 'redux';
import errorsReducer from './errorsReducer';
import userAccountReducer from './userAccountReducer';

export default combineReducers({
    errors: errorsReducer, 
    items: userAccountReducer
});
