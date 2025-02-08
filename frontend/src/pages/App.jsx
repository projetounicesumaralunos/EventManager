import React from "react";
import { Header, Footer, EventCard } from "../components";



function App() {
  return (
    <div className="min-h-screen bg-gray-100 flex flex-col items-center">
      <Header />

      <main className="p-4 w-full max-w-2xl flex flex-wrap gap-4 justify-center">
        <EventCard />
        <EventCard />
        <EventCard />
      </main>

      <Footer />
    </div>
  );
}

export default App;
