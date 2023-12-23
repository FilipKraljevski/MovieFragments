package com.example.lab_fragments.domain.movie.data

import com.example.lab_fragments.domain.movie.model.Movie

fun moviesList(): MutableList<Movie>{
    return mutableListOf(
        Movie(
            poster = "https://m.media-amazon.com/images/M/MV5BNDYxNjQyMjAtNTdiOS00NGYwLWFmNTAtNThmYjU5ZGI2YTI1XkEyXkFqcGdeQXVyMTMxODk2OTU@._V1_SX300.jpg",
            id = "1",
            title = "The Avengers",
            director = "Joss Whedon",
            plot = "Earth's mightiest heroes must come together and learn to fight as a team if they are going to stop the mischievous Loki and his alien army from enslaving humanity.",
            actors = "Robert Downey Jr., Chris Evans, Scarlett Johansson"
        ),
        Movie(
            poster = "https://m.media-amazon.com/images/M/MV5BMTM4OGJmNWMtOTM4Ni00NTE3LTg3MDItZmQxYjc4N2JhNmUxXkEyXkFqcGdeQXVyNTgzMDMzMTg@._V1_SX300.jpg",
            id = "2",
            title = "Avengers: Age of Ultron",
            director = "Joss Whedon",
            plot = "When Tony Stark and Bruce Banner try to jump-start a dormant peacekeeping program called Ultron, things go horribly wrong and it's up to Earth's mightiest heroes to stop the villainous Ultron from enacting his terrible plan.",
            actors = "Robert Downey Jr., Chris Evans, Mark Ruffalo"
        ),
        Movie(
            poster = "https://m.media-amazon.com/images/M/MV5BMjMxNjY2MDU1OV5BMl5BanBnXkFtZTgwNzY1MTUwNTM@._V1_SX300.jpg",
            id = "3",
            title = "Avengers: Infinity War",
            director = "Anthony Russo, Joe Russo",
            plot = "The Avengers and their allies must be willing to sacrifice all in an attempt to defeat the powerful Thanos before his blitz of devastation and ruin puts an end to the universe.",
            actors = "Robert Downey Jr., Chris Hemsworth, Mark Ruffalo"
        ),
        Movie(
            poster = "https://m.media-amazon.com/images/M/MV5BMTc5MDE2ODcwNV5BMl5BanBnXkFtZTgwMzI2NzQ2NzM@._V1_SX300.jpg",
            id = "4",
            title = "Avengers: Endgame",
            director = "Anthony Russo, Joe Russo",
            plot = "After the devastating events of Avengers: Infinity War (2018), the universe is in ruins. With the help of remaining allies, the Avengers assemble once more in order to reverse Thanos' actions and restore balance to the universe.",
            actors = "Robert Downey Jr., Chris Evans, Mark Ruffalo"
        ),
        Movie(
            poster = "https://m.media-amazon.com/images/M/MV5BZDA0OGQxNTItMDZkMC00N2UyLTg3MzMtYTJmNjg3Nzk5MzRiXkEyXkFqcGdeQXVyMjUzOTY1NTc@._V1_SX300.jpgg",
            id = "5",
            title = "Avatar",
            director = "James Cameron",
            plot = "A paraplegic Marine dispatched to the moon Pandora on a unique mission becomes torn between following his orders and protecting the world he feels is his home.",
            actors = "Sam Worthington, Zoe Saldana, Sigourney Weaver"
        )
    )
}