package com.twitter.finagle.ssl.client

import com.twitter.finagle.ssl.ApplicationProtocols
import com.twitter.finagle.ssl.CipherSuites
import com.twitter.finagle.ssl.KeyCredentials
import com.twitter.finagle.ssl.Protocols
import com.twitter.finagle.ssl.TrustCredentials

/**
 * SslClientConfiguration represents the collection of parameters that an engine factory
 * should use to configure a TLS client [[Engine]].
 *
 * @param hostname If specified, this value should match one of the names specified in
 * the server's X.509 certificate.
 *
 * @param keyCredentials The credentials used by the client engine to verify itself to
 * a remote peer.
 *
 * @param trustCredentials The credentials used by the client to validate a remote
 * peer's credentials.
 *
 * @param cipherSuites The cipher suites which should be used by a particular client engine.
 *
 * @param protocols The protocols which should be enabled for use with a particular client engine.
 *
 * @param applicationProtocols The ALPN or NPN protocols which should be supported by a particular
 * client engine.
 *
 * @param forceJdk when true, forces use of the JDK SslProvider. Note that until
 * JDK 9, this does not work with H2. For this reason, it's false by default.
 */
case class SslClientConfiguration(
  hostname: Option[String] = None,
  sniHostName: Option[String] = None,
  keyCredentials: KeyCredentials = KeyCredentials.Unspecified,
  trustCredentials: TrustCredentials = TrustCredentials.Unspecified,
  cipherSuites: CipherSuites = CipherSuites.Unspecified,
  protocols: Protocols = Protocols.Unspecified,
  applicationProtocols: ApplicationProtocols = ApplicationProtocols.Unspecified,
  forceJdk: Boolean = false)
