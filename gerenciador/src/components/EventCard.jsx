import React from 'react';
import PropTypes from 'prop-types';

function EventCard({ title = "", date = "", location = "" }) {
    return (
      <div className="border p-4 rounded-lg shadow-md bg-white w-80 h-40">
        <h2 className="text-xl font-bold">{title || "Título do Evento"}</h2>
        <p className="text-gray-600">{date || "Data do Evento"}</p>
        <p className="text-gray-800">{location || "Local do Evento"}</p>
      </div>
      );
  }
  
  EventCard.propTypes = {
    title: PropTypes.string,
    date: PropTypes.string,
    location: PropTypes.string,
  };
  
  export default EventCard;
  
  