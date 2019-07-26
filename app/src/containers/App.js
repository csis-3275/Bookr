import {withRouter} from "react-router";
import {connect} from "react-redux";

import App from "../App";

const mapStateToProps = (state) => {
    let loggedIn = state.auth && state.auth.user ? true : false;
    return {
        loggedIn: loggedIn
    };
};

const mapDispatchToProps = {

};

const AppContainer = connect(
    mapStateToProps,
    mapDispatchToProps
)(App);

export default AppContainer;