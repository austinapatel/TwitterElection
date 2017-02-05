# TwitterElection
A Java program utilizing the Twitter API to display tweets based on a query for each state in the United States.  Data is then displayed on a visual map based on the opinions present in the tweets.

Got 3rd place during the ANova Hacks Hackathon in Berkeley 2016.

To run program:
1. Add "/lib/" folder in root directory.
2. Download Stanford's CoreNLP library from http://stanfordnlp.github.io/CoreNLP/.
3. Add the "ejml-0.23.jar", "stanford-corenlp-3.7.0.jar" and "stanford-corenlp-3.7.0-models.jar" files in the downloaded library to the lib folder.
4. Add a twitter4j.properties file in the base directory.  See below for format.
5. Compile.

twitter4j.properties file format (Enter your Twitter API information for each property):
"debug=false
oauth.consumerKey=
oauth.consumerSecret=
oauth.accessToken=
oauth.accessTokenSecret="
