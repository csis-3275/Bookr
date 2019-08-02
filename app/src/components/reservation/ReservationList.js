import React, { Component } from 'react'
import Axios from 'axios';

class ReservationList extends Component {
    constructor(props) {
        super(props);
        this.state = {
            reservations: []
        }
    }

    async componentWillMount(){
        try {
            setInterval(async() => {
                Axios.get(`http://localhost:8888/api/reservations/get/${this.props.userId}`).then((response) =>{
                    this.setState({
                        reservations: response.data
                    })
                })
            }, 2000);
        } catch (error) {
            
        }
    }

    render() {
        // console.log(this.state.reservations);
        const myreservations = this.state.reservations;
        console.log(myreservations);
        const list_res = myreservations.map((res, index) => {
            return <li key={index} className="px-0 py-0 my-3">
                <h4 className="text-dark mt-2">Title: {res._event_title}</h4>
                <p className="text-dark mb-0">Begins: {res._start_date}</p>
                <p className="text-dark mb-0">Ends: {res._start_date}</p>
                <p className="text-dark mb-2">Venue: {res._room_id}</p>
                <div className="mt-3 h-0 w-100 border border-secondary"></div>
            </li>;
        })

        return (
            <ul className="px-0 py-0 list-style-none">
                {list_res}
            </ul>
        )
    }
}

export default ReservationList