import React, { Component } from 'react'



export default class Reservation extends Component {
    render() {
        return (
            <div class="bg-light py-5 px-5 rounded" >
                <div className="d-flex flex-column">
                    <h4 className="text-dark">Reservations</h4>
                    <span className="p-2 text-dark">Flex item 1</span>
                    <span className="p-2 text-dark">Flex item 2</span>
                    <span className="p-2 text-dark">Flex item 3</span>
                    <span className="p-2 text-dark">Flex item 4</span>
                    <span className="p-2 text-dark">Flex item 5</span>
                    <span className="p-2 text-dark">Flex item 6</span>
                </div>
            </div>
        )
    }
}
