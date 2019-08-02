import React, { Component } from 'react';
import Axios from 'axios';
import { Button } from 'react-bootstrap';

class MessagesList extends Component {
    constructor(props) {
        super(props);
        this.state = { 
            requests: []
         }
    }

    async componentWillMount(){
        try {
            setInterval(async() => {
                Axios.get(`http://localhost:8888/api/requests/all`).then((response) =>{
                    this.setState({
                        requests: response.data
                    })
                })
            }, 2000);
        } catch (error) {
            
        }
    }

    render() { 
        const user_requests = this.state.requests;
        console.log(user_requests);
        const list_req = user_requests.map((req, index) => {
            return <li key={index} className="px-0 py-0 my-3">
                <h4 className="text-dark mt-2">Title: {req._title}</h4>
                <p className="text-dark mb-0"><span className="font-weight-bold">Sent on: </span>{req._date_sent}</p>
                <p className="text-dark mb-0"><span className="font-weight-bold">Message: </span>{req._message}</p>
                <p className="text-dark mb-2"><span className="font-weight-bold">Sent by: </span>{req._user_id}</p>
                <div className="mt-3 h-0 w-100 border border-secondary">
                </div>
            </li>;
        })

        return (
            <ul className="px-3 py-0 list-style-none">
                {list_req}
            </ul>
        )
    }
}
 
export default MessagesList;