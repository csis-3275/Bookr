import React, { Component } from 'react';
import Header from '../partials/Header';
import { Container, Row, Column } from 'react-bootstrap';

class Dashboard extends Component {
    constructor(props) {
        super(props);
        this.state = {  }
    }
    render() { 
        return ( 
            <div>
                <Header />
                <Container className="mx-0 mt-auto">
                    <Row>
                        <div>U</div>
                    </Row>
                </Container>
            </div>
         );
    }
}
 
export default Dashboard;