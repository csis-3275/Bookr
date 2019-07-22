import React, { Component } from 'react'
import { Column, Row } from "simple-flexbox";
import '../reservation/reservation.css';


export default class Reservation extends Component {
    render() {
        return (
            <div >
                <div className="d-flex flex-column">
                    <div className="p-2">Reservations</div>
                </div>
                <div className="d-flex2 flex-column">
                    <div className="p-2">
                        <span>Flex item 1</span>
                        <span>Date</span>
                        <span>Room</span>
                    </div>
                    <div className="p-2">Flex item 2</div>
                    <div className="p-2">Flex item 3</div>
                    <div className="p-2">Flex item 4</div>
                    <div className="p-2">Flex item 5</div>
                    <div className="p-2">Flex item 6</div>
                </div>
            </div>
        )
    }
}
